#함수의 매개변수로 함수 전달
def ten_times(func):
    for i in range(5):
        func()

def print_hello():
    print("Hello")

ten_times(print_hello)

def add(x,y):
    return x+y
def apply_operation(operation, x,y):
    return operation(x,y)
result = apply_operation(add,3,4)
print(result)