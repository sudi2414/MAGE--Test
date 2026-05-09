from utils import coder_llm

class InspectorAgent:

    def inspect_tests(self, source_code, test_code):

        prompt = f"""
You are an expert Java testing inspector.

Analyze the generated JUnit tests.

Check for:
1. Syntax errors
2. Wrong assertions
3. Missing imports
4. Invalid JUnit5 usage
5. Logical mistakes

Source Code:
{source_code}

Generated Tests:
{test_code}

Return corrected Java JUnit5 code only.
"""

        response = coder_llm.invoke(prompt)

        return response.content