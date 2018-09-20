##The first dictionary, called Names, maps the stock symbol to the company name
##(example: "GM" maps to "General Motors").
Names = {}

##The second dictionary, called Prices, maps the stock symbol to a list of 2
##floating point numbers corresponding to the buy price (the price the user paid
##for the stock) and the current market price (the price the user could sell the stock for today).
Prices = {}

##The third dictionary, called Exposure, maps the stock symbol to a list of 2
##floating point numbers, corresponding to the number of shares purchased, and
##the risk associated with holding onto the stock (i.e. How likely the stock is to gain value in the future).
Exposure = {}

##Your program should consist of the following functions:
##AddName - Asks the user for a Stock Symbol and Name pairing then adds it to the Names dictionary.
def AddName ():
    stock_symbol = input("Please enter the stock symbol you wish to add: ")
    company_name = input("Please enter the name of the company you wish to add: ")

    Names[stock_symbol] = company_name
    return stock_symbol

##AddPrices - Takes a Stock Symbol as an input parameter, then asks the user for the Buy price and the
##Current price of the corresponding stock, adding them to the Prices dictionary.
def AddPrices(stock_symbol):
    user_input = input("Please enter the price of the stock you wish to add: ")
    buy_price = float(user_input)
    
    user_input = input("Please enter the current price fo the stock you wish to add: ")
    current_price = float(user_input)

    Prices[stock_symbol] = [buy_price, current_price]

##AddExposure - Takes a Stock Symbol as an input parameter, then asks the user for the Risk and Shares
##of the corresponding stock, adding them to the Exposure dictionary.
def AddExposure (stock_symbol):
    risk = float(input("Please enter the risk of the share you wish to add: "))
    shares = float(input("How many shares ase you dealing with? "))

    Exposure[stock_symbol] = [risk,shares]


##AddStock - Calls AddName, AddPrices, and AddExposure to add a new stock to the portfolio.
def AddStock ():
    stock_symbol = AddName()
    AddPrices(stock_symbol)
    AddExposure(stock_symbol)


##GetSale - Finds the maximum expected value of selling a stock. The expected sale value of a stock
##is the current profit minus the future value of the stock:
##Expected Sale value = ( ( Current Price - Buy Price ) - Risk * CurrentPrice ) * Shares
##The GetSale function should calculate this value for each stock in the portfolio, and return
##the stock symbol with the highest expected sale value.
def GetSale():
    highest_esv = -99999
    best_stock = ""
    
    for stock_symbol in Names:
        price_list = Prices[stock_symbol]
        exposure_list = Exposure[stock_symbol]
        
        buy_price = price_list[0]
        current_price = price_list[1]
        risk = exposure_list[0]
        shares = exposure_list[1]
        
        expected_sale_value= (( current_price - buy_price ) - risk * current_price ) * shares
        if expected_sale_value > highest_esv:
            highest_esv = expected_sale_value
            best_stock = stock_symbol

    return best_stock
            


##Main - Should take no arguments, but present a menu item consisting of "1. Add Stock",
##"2. Recommend Sale" and "3. Exit". If the user selects '1,' the Add Stock function is called,
##and when it is complete, the menu is presented again. If the user selects '2,' the Symbol of the
##stock corresponding to the highest expected value (returned by GetSale) should be displayed, and
##the menu presented after completion. If the user selects '3', the program should end.
def main():
    user_input = 0
    output = ""
    
    while user_input != 3:
        user_input = int(input("1. Add Stock\n2. Reccommend Sale\n3. Exit\n> "))

        if user_input == 1:
            AddStock()
            print("\n")

        elif user_input == 2:
            output = GetSale()
            print("I reccommend selling", output+".\n")

        elif user_input != 3:
            print("Please choose one of the following options:")
            
