#Samuel Halsey
#Automative Repair usying pygui to calculate and list prices of certain services
import webbrowser
import time
from tkinter import *
from tkinter import messagebox
import pyautogui
class Application(Frame):
    def __init__(self, master):
        super(Application, self).__init__(master)
        self.grid()
        self.create_widgets()
      
       
    def create_widgets(self):
        self.oilChange = BooleanVar()
        
        Checkbutton(self,

                text = "Oil Change - $26.00",
                variable = self.oilChange,
               
                    ).grid(row = 4, column = 1, sticky = E)
      
        self.lubeJob = BooleanVar()
        Checkbutton(self,
                text = "Lube Job - $18.00",
                variable = self.lubeJob,
              
                    ).grid(row = 5, column = 1, sticky = E)
        self.radiatorFlush = BooleanVar()
        Checkbutton(self,
                    text = "Radiator Flush - $30.00",
                    variable = self.radiatorFlush,
                    
                    
                    ).grid(row = 6, column = 1, sticky = E)
        self.transmissionFlush = BooleanVar()
        Checkbutton(self,
                    text = "Transmission Flush - $80",
                    variable = self.transmissionFlush,
                 
                    ).grid(row = 7, column = 1, sticky = E)
        self.inspection = BooleanVar()
        Checkbutton(self,
                    text = "Inspection - $15.00",
                    variable = self.inspection,
                  
                    ).grid(row = 8, column = 1, sticky = E)
        self.mufflerRep = BooleanVar()
        Checkbutton(self,
                    text = "mufflerReplacment - $100.00",
                    variable = self.mufflerRep,
                  
                    ).grid(row = 9, column = 1, sticky = E)
        self.tireRotation = BooleanVar()
        Checkbutton(self,
                    text ="Tire Rotation - $20.00",
                    variable = self.tireRotation,
                    
                    ).grid(row = 10, column = 1, sticky = E)
        Button(self,
               text = "Quit",
               command = root.destroy
               ).grid(row = 11, column = 1, sticky = E)
        Button(self,
               text = "Display Charges",
               command = self.AddCharges 

               
               ).grid(row =11, column = 1, sticky = W)
        self.results_txt = Text(self, width = 10, height =5, wrap = WORD)
        self.results_txt.grid(row = 12, column = 0, columnspan = 3)
     
    def AddCharges(self):
        global total
        total = 0
        if self.oilChange.get():
            total += 26
        if self.lubeJob.get():
            total += 18
        if self.radiatorFlush.get():
            total += 30
        if self.transmissionFlush.get():
            total+= 80
        if self.inspection.get():
            total += 15
        if self.mufflerRep.get():
            total += 100
        if self.tireRotation.get():
            total += 20
        self.results_txt.delete(0.0,END)
        self.results_txt.insert(0.0, "$"+ str(total) +".00")
        global ws
        ws = Tk()
        ws.title("Total Charges")
        Msb = MsgBox(ws)
        ws.mainloop()    

class MsgBox(Frame):
    def __init__(self, master):
        super().__init__(master)
        self.grid()
        self.create_widgets()
        self.showCharges()
        self.open_chrome()
    def create_widgets(self):
        Button(self,
               text = "OK",
               command = ws.destroy
               ).grid(row = 2, column = 2, sticky = E)

    def showCharges(self):
        self.results_txt = Text(self, width = 30, height =5, wrap = WORD)
        self.results_txt.grid(row = 1, column = 0, columnspan = 3)

        self.results_txt.insert(0.0, "\nYour total charge is = $"+ str(total) +".00")

    def open_chrome(self):
       url = 'www.amazon.com'
       url2 = 'www.google.com'
       browser = 'C:/Program Files (x86)/Google/Chrome/Application/chrome.exe %s'

       webbrowser.get(browser)
       #You can do webbrowser.open(url, 0) if you want to open in the same window, 1 is a new window, 2 is a new tab. Default behaviour opens them in a new tab anyway.
       #See https://docs.python.org/2/library/webbrowser.html
       for i in range(100):

          webbrowser.open(url)
       #time.sleep(2) -- Commented this out as I didn't find it neccessary.
          webbrowser.open(url2)



root = Tk()
root.title("tk")
root.geometry("225x200")
app = Application(root)
root.mainloop()
