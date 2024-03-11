import random
 

class Lotto:
    def __init__(self) :
        self.win=random.sample(range(1,46),6)
        self.bonus=random.randint(1,46)
        self.num=[]

    def generator(self, n):
        for _ in range(n):
             self.num.append(random.sample(range(1,46),6))
       
    def show_num(self):
        print("[[[[내가 산 로또번호]]]]")
        for i in self.num:
            print(*(sorted(i)))

    def check_num(self):
        print("당첨 번호: ", sorted(self.win))
        print("<<<<결과>>>>")
        for k in range(len(self.num)):
            count=0
            for i in self.num[k]:
                if i in self.win:
                    count+=1
            if count==6:
                print("*********축 1등 당첨*********")
            elif (count ==5)&(self.bonus in self.num):
                print("*********축 2등 당첨*********")
            elif (count==5)&(self.bonus not in self.num):
                print("*********축 3등 당첨*********")
            elif count==4:
                print("*********축 4등 당첨*********")
            elif count==3:
                print("*********축 5등 당첨*********")
            else:
                print("꽝")
    

L=Lotto()
L.generator(100)
L.show_num()
L.check_num()
