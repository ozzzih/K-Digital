class Restaurant:
    def __init__(self, restaurant_name, cuisine_type):
        self.restaurant_name=restaurant_name
        self.cuisine_type=cuisine_type
    
    def describe_restaurant(self):
        print(self.restaurant_name)
        print(self.cuisine_type)

    def open_restaurant(self):
        print(f"{self.restaurant_name} is open")
class IceCreamStand(Restaurant):
    def __init__(self, name, ctype, flavors):
        super().__init__(name, ctype)
        self.flavors = flavors
    def show_flavors(self):
        print("맛: {}".format(self.flavors))

ice_cream=IceCreamStand('Italy', 'pizza', '매운맛')
ice_cream.show_flavors()

new_rest = Restaurant("ABC", "양식")
new_rest.describe_restaurant()
new_rest.open_restaurant()

new_rest1 = Restaurant("japan", "일식")
new_rest1.describe_restaurant()

new_rest2 = Restaurant("chinafood", "중식")
new_rest2.describe_restaurant()

new_rest3 = Restaurant("koreafood", "한식")
new_rest3.describe_restaurant()

class User:
    def __init__(self, first_name, last_name):
        self.first_name=first_name
        self.last_name = last_name

    def describe_user(self):
        print(f"사용자 {self.first_name} {self.last_name}의 정보입니다.")

    def greet_user(self):
        print(f"{self.first_name}{self.last_name}님, 환영합니다.")

user1 = User("Oh", "Jihyun")
user1.describe_user()
user1.greet_user()