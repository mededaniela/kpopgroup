for (let key in countriesData) {
  let option = document.createElement("option");
  option.setAttribute('value', data[key]);

  let optionText = document.createTextNode(key);
  option.appendChild(optionText);

  membersDropDown.appendChild(option);
}