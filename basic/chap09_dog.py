class  Dog:
    """개를 표현하는 클래스"""

    def __init__(self, name, age):
        """name과 age 속성 초기화"""
        self.name = name
        self.age = age
        self.__price = 100

    def sit(self):
        """앉기"""
        print(f"{self.name} is now sitting.")
    
    def roll_over(self):
        """구르기"""
        print(f"{self.name} rolled over!")

my_dog=Dog('Willie', 6) #생성자 호출 > 인스턴스 생성 > __init__함수 자동호출
my_dog.sit()
print(f"개 이름은 {my_dog.name}")