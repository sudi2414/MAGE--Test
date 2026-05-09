from utils import coder_llm

class InitializerAgent:

    def generate_initial_test(self, source_code):

        prompt = f"""
You are an expert Java unit test generator.

Generate JUnit5 test cases.

Source Code:
{source_code}

Only generate Java code.
"""

        response = coder_llm.invoke(prompt)

        return response.content