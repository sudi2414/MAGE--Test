from langchain_ollama import ChatOllama

coder_llm = ChatOllama(
    model="qwen2.5-coder:7b",
    temperature=0
)

reasoning_llm = ChatOllama(
    model="qwen2.5-coder:7b",
    temperature=0
)

def read_java_file(path):

    with open(path, "r", encoding="utf-8") as f:
        return f.read()