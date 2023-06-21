function changeVMName(inputElement) {
    var vmName = inputElement.previousElementSibling;
    var fileName = inputElement.files[0].name;

    if (fileName) {
        vmName.innerHTML = fileName;
    } else {
        vmName.innerHTML = "Nom de la VM";
    }
}