from utils import reasoning_llm

class PanelistAgent:

    def review_oracle(self, source_code, test_code):

        prompt = f"""
You are a senior software testing expert.

Analyze whether the JUnit assertions are semantically correct.

Check:
1. Wrong assertions
2. Logical mistakes
3. Incorrect expected outputs
4. Exception correctness

Source Code:
{source_code}

JUnit Tests:
{test_code}

Explain mistakes and provide corrected assertions.
"""

        response = reasoning_llm.invoke(prompt)

        return response.content