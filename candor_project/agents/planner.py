from utils import coder_llm

class PlannerAgent:

    def create_test_plan(self, source_code, current_tests):

        prompt = f"""
You are a software testing expert.

Analyze the existing tests and suggest:
1. Edge cases
2. Boundary cases
3. Exception cases
4. Missing branch coverage

Source Code:
{source_code}

Current Tests:
{current_tests}

Generate a testing plan only.
"""

        response = coder_llm.invoke(prompt)

        return response.content