def sum_numbers (a_list):
    my_sum = 0
    for item in a_list:
        my_sum += item
    return my_sum

def get_smallest(a_list):
    my_list = list(a_list)
    my_list.sort()
    return my_list[0]

def list_less_than_equal_to(a_list,maximum):
    my_list = []
    for value in a_list:
        if value <= maximum:
            my_list.append(value)
    return my_list
