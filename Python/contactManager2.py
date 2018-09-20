#Class Person has following:
#*first_name
#*last_name
#*phone_number

class Person():
    def __init__(self):
        self._first_name = ""
        self._last_name = ""
        self._phone_number = ""

    def get_first_name(self):
        return self._first_name

    def set_first_name(self, new_first_name):
        self._first_name = new_first_name

    def get_last_name(self):
        return self._last_name

    def set_last_name(self, new_last_name):
        self._last_name = new_last_name

    def get_phone_number(self):
        return self._phone_number

    def set_phone_number(self, new_phone_number):
        self._phone_number = new_phone_number

    def get_info(self):
        info = self._first_name+" "+self._last_name+"\n"
        info += self._phone_number
        return info

#Your friend
#*email
#*birth_date

class Friend(Person):
    def __init__(self):
        super().__init__()
        self._email = ""
        self._birth_date = ""

    def get_email(self):
        return self._email

    def set_email(self, new_email):
        self._email = new_email

    def get_birth_date(self):
        return self._birth_date
    
    def set_birth_date(self, new_birth_date):
        self._birth_date = new_birth_date

    def get_info(self):
        info = self._first_name+" "+self._last_name+"\n"
        info += self._phone_number + "\n"
        info += self._email + "\n"
        info += self._birth_date

        return info

class Contact_Manager():
    def __init__(self):
        self._contacts = []

    def add_contact(self, new_contact):
        self._contacts.append(new_contact)

    def lookup_contacts(self, last_name_to_search):
        matching_contacts = []
        
        for contact in self._contacts:
            if contact.get_last_name() == last_name_to_search:
                matching_contacts.append(contact)

        return matching_contacts


def add_contact(contact_manager):
    new_contact = get_new_contact()

    contact_manager.add_contact(new_contact)

def get_new_contact():
    contact_type = input('Would you like to add a "Friend" or a "Person" ==> ')

    if contact_type == "Friend":
        new_contact = get_friend()
    elif contact_type == "Person":
        new_contact = get_person()
    else:
        print("That is an invalid contact type!")

    return new_contact

def get_friend():
    new_friend = Friend()

    first_name = input("Please enter a first name: ")
    last_name = input("PLease enter a last name: ")
    phone_number = input("Please enter a phone number: ")
    email = input("Please enter an email address: ")
    birthday = input("Please enter a birth date: ")

    new_friend.set_first_name(first_name)
    new_friend.set_last_name(last_name)
    new_friend.set_phone_number(phone_number)
    new_friend.set_email(email)
    new_friend.set_birth_date(birthday)

    return new_friend

def get_person():
    new_person = Person()

    first_name = input("Please enter a first name: ")
    last_name = input("Please enetr a last name: ")
    phone_number = input("Please enter a phone number: ")

    new_person.set_first_name(first_name)
    new_person.set_last_name(last_name)
    new_person.set_phone_number(phone_number)
    
    return new_person

def lookup_contacts(contact_manager):
    search_query = input("Please enter the last name you are searching for: ")
    search_results = contact_manager.lookup_contacts(search_query)
    print("Here are the contacts you are looking for:")
    for contact in search_results:
        print(contact.get_info())
        print("\n")

def exit_application():
    print("Good luck!")

def handle_invalid_menu_choice():
    print("!!! Invalid menu choice !!!")

def get_users_menu_choice():
    display_menu()

    user_input = input("==>")

    return int(user_input)

def display_menu():
    print("////" + "="* 40+"\\\\\\\\")
    print("1 ==> Add Contact")
    print("2 ==> Lookup Contacts")
    print("3 ==> Exit Application")
    print("\\\\\\\\"+"="*40+"////")

def main():
    ADD_CONTACT = 1
    LOOKUP_CONTACTS = 2
    EXIT = 3

    menu_choice = None

    contact_manager = Contact_Manager()
    
    while menu_choice != EXIT:
        menu_choice = get_users_menu_choice()
        
        if menu_choice == ADD_CONTACT:
            add_contact(contact_manager)
        elif menu_choice == LOOKUP_CONTACTS:
            lookup_contacts(contact_manager)
        elif menu_choice == EXIT:
            exit_application()
        else: #invalid menu_choice
            handle_invalid_menu_choice

    
