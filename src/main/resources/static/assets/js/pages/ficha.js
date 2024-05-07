const dynamicDiv = document.getElementById("dynamicDiv");
dynamicDiv.addEventListener("click", () => {
    dynamicDiv.style.backgroundColor = "lightblue";
    dynamicDiv.querySelector("h5").textContent = "Support is just a click away!";
});

