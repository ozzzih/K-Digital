class Car:
    """자동차를 표현하는 클래스"""

    def __init__(self, make, model, year):
        """자동차 속성 초기화"""
        self.make = make
        self.model = model
        self.year=year
        self.odometer_reading=0
    
    def get_descriptive_name(self):
        """뜻이 분명하고 깔끔한 이름 반환"""
        long_name = f"{self.year} {self.make} {self.model}"
        return long_name.title()
    
    def update_odometer(self, mileage):
        if mileage >= self.odometer_reading:
            self.odometer_reading=mileage
        else:
            print("You can't roll back an odometer!")

    def read_odometer(self):
        print(f"이 차의 주행거리는 {self.odometer_reading}")

    def increment_odometer(self, miles):
        self.odometer_reading+=miles
class Battery:
    """배터리"""
    def __init__(self, battery_size=40):
        """배터리 속성을 초기화합니다."""
        self.battery_size=battery_size
    
    def describe_battery(self):
        print(f"This car has a {self.battery_size}-kWh battery.")

    def get_range(self):
        """이 배터리로 주행할 수 있는 거리를 알려줍니다."""
        if self.battery_size == 40:
            range = 150
        elif self.battery_size == 65:
            range = 225
        print(f"This car can go about {range} miles on a full charge.")

class ElectricCar(Car):
    """전기차"""
    def __init__(self, make, model, year):
        super().__init__(make, model, year)
        self.battery=Battery()
    
    def describe_battery(self):
        """배터리 크기를 설명하는 문장을 출력합니다."""
        print(f"This car has a {self.battery_size}-kWh battery.")

    def get_descriptive_name(self):
        return super().get_descriptive_name()


my_leaf = ElectricCar('nissan', 'leaf', 2024)
print(my_leaf.get_descriptive_name())
my_leaf.battery.describe_battery()
my_leaf.battery.get_range()