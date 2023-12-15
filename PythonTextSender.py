import smtplib
import tkinter
from email.mime.text import MIMEText
from email.mime.multipart import MIMEMultipart
from bs4 import BeautifulSoup
import requests
import time
global total
total = 0
from tkinter import Tk, Label, Button
email = "textsender2023@gmail.com"
class TextSender:
#This was a program used to remotely send texts to phone numbers through a PyGui, unfortunately, it no longer works due to changes in Google's policy on third-party services logging into emails.
    def __init__(self, master):
        self.total = 0
        self.check = "Checked"
        self.master = master
        self.master.geometry("400x400")
        master.title("Instant Messaging Service")

        import datetime
        self.time = datetime.datetime.now()

        self.style = Style()

        self.title = tk.Label(master, text="Instant Messaging Service")
        self.title.pack()
        self.title.place(x=25, y=0)
        self.title.config(font=('Times New Roman', 20, 'bold'))

        self.descrip = tk.Label(master,
                                text="Note: This is a one way instant messaging service,each new \nmessage will create a new conversation. Do not use this to bully ;)")
        self.descrip.pack()
        self.descrip.place(x=0, y=50)

        self.label = Label(master, text="Enter Phone Number Below ")
        self.label.pack()
        self.label.place(x=50, y=100)
        self.label.config(font=('Times New Roman', 15, 'bold'))
        self.name_var = StringVar()
        self.labelG = tk.Entry(master,
                               text="enter phoneNum",
                               textvariable=self.name_var,
                               )

        self.name = self.name_var.get()
        self.labelG.pack()
        self.labelG.place(x=100, y=135)
        self.labelG.insert(0, "(123)-456-7890")
        self.labelG.config(fg=('gray'))

        self.label4 = Label(master, text="How many times would you like to send this message?")
        self.label4.pack()
        self.label4.place(x=0, y=160)
        self.label4.config(font=('Times New Roman', 12, 'bold'))
        self.name_var3 = IntVar()
        self.labelG4 = tk.Entry(master,
                                text="enter times",
                                textvariable=self.name_var3,
                                )

        self.numTimes = self.name_var3.get()
        self.labelG4.pack()
        self.labelG4.place(x=100, y=195)

        self.labelG4.config(fg=('gray'))

        self.label2 = Label(master, text="Enter Custom Message below ")
        self.label2.pack()
        self.label2.place(x=225, y=220)
        self.label2.config(font=("Times New Roman", 10, 'bold'))
        self.name_var1 = StringVar()

        self.labelG1 = tk.Entry(master,
                                text="Enter Message",
                                textvariable=self.name_var1,
                                )

        self.name1 = self.name_var1.get()
        self.labelG1.pack(expand=True)
        self.labelG1.insert(0, "Lorem ipsum dolor...")
        self.labelG1.config(fg=('gray'))
        self.labelG1.place(x=225, y=245)

        self.greet_button = Button(master, text="Send Custom Message", activebackground='blue',
                                   command=lambda: self.CombinFunc())
        self.greet_button.pack()

        self.greet_button.place(x=225, y=270, )
        self.greet_button.config(font=
                                 ('calibri', 10, 'bold'),
                                 foreground='blue')



        self.label3 = Label(master, text="Send the Wordle of the Day ")
        self.label3.pack()
        self.label3.config(font=
                           ('calibri', 10, 'bold'),
                           foreground='black')
        self.label3.place(x=0, y=220)

        self.wordle_button = Button(master, text="Send the Wordle", activebackground='green',
                                    fg='green',
                                    command=lambda: self.texter(self.enterPhoneNum(),
                                                                'The wordle today is ' + self.WebScrape(),
                                                                self.times()))
        self.wordle_button.pack()

        self.wordle_button.place(x=0, y=245)

        self.close_button = Button(master, text="Close", command=master.quit)
        self.close_button.pack()
        self.close_button.config(font=("calibri", 10, 'bold'), foreground="red")
        self.close_button.config(height=2, width=8)
        self.close_button.place(x=320, y=350)

    def enterPhoneNum(self):
        phoneNum = self.name_var.get()

        phoneNum1 = phoneNum
        return phoneNum

    def enterMessage(self):
        message = self.name_var1.get()

        message1 = message
        return message

    def times(self):
        times = self.name_var3.get(
        )

        return times

    def WebScrape(self):
        # The webpage URL

        URL = "https://www.tomsguide.com/news/what-is-todays-wordle-answer"
        # HTTP Request
        webpage = requests.get(URL)
        # Soup Object containing all data
        soup = BeautifulSoup(webpage.content, "html.parser")
        paragraphs = soup.find_all("p")
        worlde = soup.find_all("strong")
        wordle1 = worlde[1].get_text()
        # print(wordle1)
        # print(paragraphs[14])
        wordle = paragraphs[15].get_text()
        return wordle1

    def FindIp(self):

        URL = "https://ipapi.co/"
        URL2 = "https://tools.keycdn.com/geo"
        # HTTP Request
        webpage = requests.get(URL)
        webpage2 = requests.get(URL)
        # Soup Object containing all data
        soup = BeautifulSoup(webpage.content, "html.parser")

        paragraphs = soup.find_all(class_="text-center")
        ip = paragraphs[0]
        ip1 = str(ip)
        ip1 = ip1.replace('<div class="text-center" data-ip="', "")
        ip1 = ip1.replace('" id="jumbo-ip"> </div>', "")
        print(ip1)
        return (ip1)

    def CombinFunc(self):
        from threading import Thread

        self.texter(self.enterPhoneNum(), self.enterMessage(), self.times())

    def CreateNewTk(self):
        class TextSender1(TextSender):
            def __init__(self, master):
                # root window title and dimension
                self.master = master
                self.master.geometry("400x400")
                root = Tk()
                root.title("Running Program")
                lbl = Label(root, text="Message sending")
                lbl.config(font=("Calibri", 10, 'bold'), foreground='green')
                lbl.grid()
                close = Button(root, text="Ok",
                               command=lambda: self.texter(my_gui.enterPhoneNum(), my_gui.enterMessage(),
                                                           my_gui.times()))
                close.config(height=1, width=5)
                close.grid()

            def enterPhoneNum(self):
                phoneNum = self.name_var.get()
                return phoneNum

            def enterMessage(self):
                message = self.name_var1.get()
                return message

            def times(self):
                times = self.name_var3.get(
                )
                return times

    def texter(self, phoneNum, wordle, times):

        with smtplib.SMTP("smtp.gmail.com", 587) as server:
            server.starttls()
            server.login(email, "texter123!?")
        # The server we use to send emails in our case it will be gmail but every email provider has a different smtp
        # and port is also provided by the email provider.
        #  smtp = "smtp.gmail.com"
        #    port = 587
        # This will start our email server
        # server = smtplib.SMTP(smtp, port)
        # Starting the server
        #  server.starttls()
        # Now we need to login
        # server.login(email, pas)
        print(times)
        # sms_gateway = phoneNum + Carrier
        # Now we use the MIME module to structure our message.
        msg = MIMEMultipart()
        msg['From'] = "Your friend"
        # msg['To'] = sms_gateway
        # Make sure you add a new line in the subject
        # msg['Subject'] = "The Fog is Coming\n"
        # Make sure you also add new lines to your body
        body = wordle
        # and then attach that body furthermore you can also send html content.
        msg.attach(MIMEText(body, 'plain'))

        sms = msg.as_string()
        # self.PostIp()
        # print(self.FindIp())
        for i in phoneNum:
            if i == "-" or i == "(" or i == ")":
                import re
                phoneNum = re.sub("[^0-9]", "", phoneNum)

        if phoneNum != "" and phoneNum != "1234567890" and wordle != "" and len(phoneNum) == 10:


            print("text was sent")

            for i in range(self.times()):
                # server.sendmail(email, '6146986870@txt.att.net', self.FindIp())
                #addes each and everyone to ensure it sends
                for i in ("@txt.att.net", "@vtext.com", "@messaging.sprintpcs.com", '@tmomail.net'):
                    sms_gateway = phoneNum + i

                    server.sendmail(email, sms_gateway, sms)


        else:
            self.Error()

    def PostIp(self):
        root = Tk()
        ip = self.FindIp()
        print(ip)
        # root window title and dimension
        root.title("Funny Number")
        lbl = Label(root, text=ip + " thats a funny number!")
        lbl.config(font=("Calibri", 10, 'bold'), foreground='green')
        lbl.grid()
        close = Button(root, text="Ok", command=lambda: root.destroy())
        close.config(height=1, width=5)
        close.grid()

        # Set geometry (widthxheight)
        root.geometry('300x50')

    def Error(self):
        root = Tk()

        # root window title and dimension
        root.title("ERROR")
        lbl = Label(root, text="ERROR: Invalid Phone Number or Message Entered")
        lbl.config(font=("Calibri", 10, 'bold'), foreground='red')
        lbl.grid()
        close = Button(root, text="Ok", command=lambda: root.destroy())
        close.config(height=1, width=5)
        close.grid()

        # Set geometry (widthxheight)
        root.geometry('300x50')

        # all widgets will be here
        # Execute Tkinter
        root.mainloop()
        print("text wasnt sent")
        # Record the messages
        f = open("Records.txt", "a")
        f.write(str(self.time) + " Sent to: " + self.name_var.get() + "\nMessage:" + self.name_var1.get() + "\n")
        f.close()

        # msg.add_attachment(open('Records.txt', "r").read(), filename="Records.txt")


from random import randint


# root = Tk()
# my_gui = TextSender(root)
# root.mainloop()
def WebScrape():
    # The webpage URL

    URL = "https://www.tomsguide.com/news/what-is-todays-wordle-answer"
    # HTTP Request
    webpage = requests.get(URL)
    # Soup Object containing all data
    soup = BeautifulSoup(webpage.content, "html.parser")
    paragraphs = soup.find_all("p")
    worlde = soup.find_all("strong")
    wordle1 = worlde[1].get_text()
    # print(wordle1)
    # print(paragraphs[14])
    wordle = paragraphs[15].get_text()
    return wordle1


def FindIp():
    URL = "https://ipapi.co/"
    URL2 = "https://tools.keycdn.com/geo"
    # HTTP Request
    webpage = requests.get(URL)
    webpage2 = requests.get(URL)
    # Soup Object containing all data
    soup = BeautifulSoup(webpage.content, "html.parser")

    paragraphs = soup.find_all(class_="text-center")
    ip = paragraphs[0]
    ip1 = str(ip)
    ip1 = ip1.replace('<div class="text-center" data-ip="', "")
    ip1 = ip1.replace('" id="jumbo-ip"> </div>', "")
    print(ip1)
    return (ip1)

    # print(soup2)


if __name__ == '__main__':
    root = Tk()
    d = TextSender(root)
    mainloop()

# FindIp()
