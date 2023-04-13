var Lebensmittel = [{Art: "Eistee", Packungsgröße: "1,5l", Einkaufspreis: 1, Verkaufspreis: null, Anzahl: "3"},
    {Art: "Cola", Packungsgröße: "2l", Einkaufspreis: 1.29, Verkaufspreis: null, Anzahl: "2"},
    {Art: "Vöslauer", Packungsgröße: "5l", Einkaufspreis: 2.99, Verkaufspreis: null, Anzahl: "1"}]

function calculate(einkaufspreis){
    return einkaufspreis*1.1;
}

var key;
for (var i = 0; i < Lebensmittel.length; i++) {
    document.write("<table>");
    Lebensmittel[i]['Verkaufspreis'] = calculate(Lebensmittel[i]['Einkaufspreis']).toFixed(2);
    for (key in Lebensmittel[i]) {
        document.write("<tr><th>"+key+":"+"</th><td>"+Lebensmittel[i][key]+"</td></tr>");
    }
    document.write("<br>")
}
