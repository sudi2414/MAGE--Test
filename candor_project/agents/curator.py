from utils import coder_llm

class CuratorAgent:

    def finalize_tests(self, discussions, test_code):

        prompt = f"""
You are the lead testing curator.

Analyze all panelist discussions.

Produce FINAL corrected JUnit5 test code.

Panelist Discussions:
{discussions}

Original Test Code:
{test_code}

Return only corrected Java code.
"""

        response = coder_llm.invoke(prompt)

        return response.content