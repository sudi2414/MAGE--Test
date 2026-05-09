from utils import coder_llm

class TesterAgent:

    def generate_test_cases(self, source_code, test_plan):

        prompt = f"""
You are an expert Java unit test generator.

Generate NEW JUnit5 test cases based on the testing plan.

Source Code:
{source_code}

Testing Plan:
{test_plan}

Generate only Java test code.
"""

        response = coder_llm.invoke(prompt)

        return response.content