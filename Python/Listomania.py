##Write a function that takes a list of any size as an argument, and returns a list where all adjacent,
##equal elements have been reduced to a single element. For example [1, 2, 2, 3] would return as [1, 2, 3].
def remove_dubs (a_list):
    index = 0
    my_list = list(a_list)
    while index < len(my_list):
        if index != 0:
            if my_list[index] == my_list[index-1]:
                my_list.remove(index)
        index += 1
    return my_list

##Write a function that takes a list of numbers of any size as an argument and returns true if the list is sorted,
##and false otherwise. For example, [1, 2, 3] would return True, and [2,1,3] would return false.
def is_sorted (a_list):
    flag = True
    index = 0
    my_list = list(a_list)
    my_list.sort()
    while index < len(a_list):
        if my_list[index] != a_list[index]:
            flag = False
        index+=1
    return flag

##Write a function that takes a list of numbers of any size as an argument, and returns the sum of the numbers.
##For example, [1,2,2,3] returns 8.
def get_you_sum(a_list):
    result = 0
    index = 0
    for number in a_list:
        result += number
    return result


##Write a function that takes a list of any type and size as an argument, and returns a list where
##the elements are in reverse list order. For example ['rubber', 'baby', 'bellybutton'] returns ['bellybutton',
##'baby', 'rubber']
def reverse_list (a_list):
    reversed_list = []
    index = (len(a_list)-1)
    while index >= 0:
        reversed_list.append(a_list[index])
        index -= 1
    return reversed_list

##Write a function that takes two sorted lists as arguments, and returns a single sorted list.
##For example, providing lists [1, 5, 7] and [1, 2, 4] results in [1,1,2,4,5,7].
def merge_lists (list1, list2):
    merged_list = []
    for item in list1:
        merged_list.append(item)
    for item in list2:
        merged_list.append(item)
    merged_list.sort()
    return merged_list

##Write a function that demonstrates and tests each of the above functions.
def make_list (a_string, a_list):
    index = 0
    a_list = a_string.split(',')
    while index < len(a_list):
        a_list[index] = int(a_list[index])
        index += 1
    return a_list

def make_string(a_list, a_string):
    index = 0
    while index < len(a_list):
        a_string = a_string+str(a_list[index])
        index +=1
    return a_string
        

def main():
    input_string = ""
    list1 = []
    list2 = []
    display_string = ""
    flag = False
    summation = 0

    input_string = input("Please enter a comma-seperated list of ints from which doubles can be removed: ")
    list1 = make_list(input_string,list1)
    display_string = make_string(list1,display_string)
    print("Before removing doubles:\n"+display_string)
    display_string = ""
    list1 = remove_dubs(list1)
    display_string = make_string(list1,display_string)
    print("After removing doubles:\n"+display_string)
    display_string = ""
    
    flag = is_sorted(list1)
    if (flag):
        print("This list is sorted.")
    else:
        print("This list is not sorted.")
        
    summation = get_you_sum(list1)
    print("The summation of that list is: "+str(summation)+".")
    
    list1 = reverse_list(list1)
    display_string = make_string(list1,display_string)
    print("Backwards, that list is", display_string+".")
    display_string = ""
    
    input_string = input("Please enter another comma-seperated list of ints: ")
    list2 = make_list(input_string,list2)
    list1 = merge_lists(list1,list2)
    display_string = make_string(list1,display_string)
    print("Merged, those strings look like this:\n"+display_string)
