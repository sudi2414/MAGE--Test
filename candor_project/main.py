import os
import shutil

from utils import read_java_file

from agents.initializer import InitializerAgent
from agents.planner import PlannerAgent
from agents.tester import TesterAgent
from agents.inspector import InspectorAgent
from agents.panelist import PanelistAgent
from agents.curator import CuratorAgent


# -------------------------------
# CREATE AGENTS
# -------------------------------
initializer = InitializerAgent()
planner = PlannerAgent()
tester = TesterAgent()
inspector = InspectorAgent()
curator = CuratorAgent()


# -------------------------------
# FOLDERS
# -------------------------------
SOURCE_FOLDER = "source_code"
GENERATED_FOLDER = "generated_tests"

JAVA_MAIN_FOLDER = "java_project/src/main/java"
JAVA_TEST_FOLDER = "java_project/src/test/java"


# Create folders if not present
os.makedirs(GENERATED_FOLDER, exist_ok=True)
os.makedirs(JAVA_MAIN_FOLDER, exist_ok=True)
os.makedirs(JAVA_TEST_FOLDER, exist_ok=True)


# -------------------------------
# PROCESS ALL JAVA FILES
# -------------------------------
for file in os.listdir(SOURCE_FOLDER):

    if file.endswith(".java"):

        print("\n" + "=" * 60)
        print(f"PROCESSING: {file}")
        print("=" * 60)

        file_path = os.path.join(SOURCE_FOLDER, file)

        # Read source code
        source_code = read_java_file(file_path)

        # Extract class name
        class_name = file.replace(".java", "")

        # Capitalize first letter
        class_name_cap = class_name[0].upper() + class_name[1:]



        # -------------------------------
        # STEP 1 - INITIAL TESTS
        # -------------------------------
        print("\nINITIAL TESTS\n")

        initial_tests = initializer.generate_initial_test(
            source_code
        )

        print(initial_tests)



        # -------------------------------
        # STEP 2 - TEST PLAN
        # -------------------------------
        print("\nTEST PLAN\n")

        plan = planner.create_test_plan(
            source_code,
            initial_tests
        )

        print(plan)



        # -------------------------------
        # STEP 3 - GENERATE TESTS
        # -------------------------------
        print("\nNEW GENERATED TESTS\n")

        new_tests = tester.generate_test_cases(
            source_code,
            plan
        )

        print(new_tests)



        # -------------------------------
        # STEP 4 - INSPECT TESTS
        # -------------------------------
        print("\nINSPECTED TESTS\n")

        inspected = inspector.inspect_tests(
            source_code,
            new_tests
        )

        print(inspected)



        # -------------------------------
        # STEP 5 - PANELIST REVIEW
        # -------------------------------
        print("\nPANEL DISCUSSIONS\n")

        panel_outputs = []

        # Using 1 panelist for faster execution
        for i in range(1):

            print(f"\nPANELIST {i+1}\n")

            panelist = PanelistAgent()

            result = panelist.review_oracle(
                source_code,
                inspected
            )

            panel_outputs.append(result)

            print(result)



        # -------------------------------
        # STEP 6 - FINAL CURATION
        # -------------------------------
        print("\nFINAL CURATED TESTS\n")

        final_tests = curator.finalize_tests(
            panel_outputs,
            inspected
        )

        # REMOVE MARKDOWN CODE BLOCKS
        final_tests = final_tests.replace(
            "```java",
            ""
        )

        final_tests = final_tests.replace(
            "```",
            ""
        )

        # REMOVE EXTRA WHITESPACES
        final_tests = final_tests.strip()

        print(final_tests)



        # -------------------------------
        # STEP 7 - SAVE GENERATED TESTS
        # -------------------------------
        test_file_name = f"{class_name_cap}Test.java"

        generated_test_path = os.path.join(
            GENERATED_FOLDER,
            test_file_name
        )

        with open(
            generated_test_path,
            "w",
            encoding="utf-8"
        ) as f:

            f.write(final_tests)

        print(f"\nTEST FILE SAVED: {generated_test_path}")



        # -------------------------------
        # STEP 8 - COPY SOURCE FILE
        # -------------------------------
        shutil.copy(
            file_path,
            os.path.join(
                JAVA_MAIN_FOLDER,
                f"{class_name_cap}.java"
            )
        )

        print(f"SOURCE FILE COPIED TO: {JAVA_MAIN_FOLDER}")



        # -------------------------------
        # STEP 9 - COPY TEST FILE
        # -------------------------------
        shutil.copy(
            generated_test_path,
            os.path.join(
                JAVA_TEST_FOLDER,
                test_file_name
            )
        )

        print(f"TEST FILE COPIED TO: {JAVA_TEST_FOLDER}")



        # -------------------------------
        # STEP 10 - RUN MAVEN TESTS
        # -------------------------------
        print("\nRUNNING MAVEN TESTS...\n")

        current_dir = os.getcwd()

        os.chdir("java_project")

        os.system("mvn clean")
        os.system("mvn test")



        # -------------------------------
        # STEP 11 - RUN PITEST
        # -------------------------------
        print("\nRUNNING MUTATION TESTING...\n")

        os.system(
            "mvn org.pitest:pitest-maven:mutationCoverage"
        )



        # -------------------------------
        # STEP 12 - PRINT METRICS
        # -------------------------------
        print("\n" + "-" * 60)
        print(f"METRICS FOR: {class_name_cap}")
        print("-" * 60)

        print("Metrics Generated Successfully")

        print("\nKey Metrics:")
        print("1. Line Coverage")
        print("2. Branch Coverage")
        print("3. Mutation Score")
        print("4. Test Strength")
        print("5. Compilation Success")
        print("6. Test Pass Rate")

        print("\nJaCoCo Report:")
        print("target/site/jacoco/index.html")

        print("\nPiTest Report:")
        print("target/pit-reports/")

        os.chdir(current_dir)



print("\n" + "=" * 60)
print("ALL JAVA FILES PROCESSED SUCCESSFULLY")
print("=" * 60)