DinnerOrder = {"Larry":"Boiled Potatoes", "Jim":"Cupcakes", "Phil":"Sirracha", "Ryan": "Peanut Butter and Bologna Sandwich"}
DinnerOrder["Chris"] = "Brussel Sprouts"
DinnerOrder["Larry"] = "Haggis"
for diner, order in DinnerOrder.items():
    print(diner, order)
