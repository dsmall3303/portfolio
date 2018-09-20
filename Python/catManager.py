class Cat():
    def __init__(self):
        self.name = ""
        self.age = 0

    def get_info(self):
        info = ""
        info += self.name + ", "
        info += str(self.age)
        return info

cats = []

def add_cat():
    new_cat = Cat()
    
    new_cat.name = name_entry.get()
    new_cat.age = int(age_entry.get())

    cats.append(new_cat)

    update_listbox()

def update_listbox():
    cat_listbox.delete(0, END)

    for cat in cats:
        cat_listbox.insert(END, cat.get_info())

def display_info():
    selected_indices = cat_listbox.curselection()

    if len(selected_indices) > 0:
        first_index = int(selected_indices[0])
        cat = cats[first_index]
        info_label["text"] = cat.get_info()


# build the GUI
from tkinter import *

root = Tk()


#instantiate the controls
name_label = Label(root, text = "Name")
name_entry = Entry(root)

age_label = Label(root, text = "Age")
age_entry = Entry(root)

add_cat_button = Button(root, text = "Add Cat", command = add_cat)

cat_list_label = Label(root, text = "Cats")
cat_listbox = Listbox(root)

display_cat_info_button = Button(root, text = "Display Info", command = display_info)

info_label = Label(root, text = " ")


#placing controls by grid
name_label.grid(row=0, column=0)
name_entry.grid(row=1, column=0)

age_label.grid(row = 2, column = 0)
age_entry.grid(row = 3, column = 0)

add_cat_button.grid(row = 4, column = 0)

cat_list_label.grid(row = 0, column = 1)
cat_listbox.grid(row = 1, column = 1, rowspan = 3)

display_cat_info_button.grid(row = 4, column = 1)

info_label.grid(row = 5, column = 0, columnspan = 2)
root.mainloop()
