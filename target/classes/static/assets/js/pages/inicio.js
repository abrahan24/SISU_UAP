document.getElementById("animateButton").addEventListener("click", function () {
    var welcomeText = document.getElementById("welcomeText");
    welcomeText.style.animation = "none"; // Detén la animación anterior
    welcomeText.style.color = "#ff5733"; // Cambia el color del texto
    setTimeout(function () {
        welcomeText.style.color = "#0073e6"; // Restaura el color original
        welcomeText.style.animation = "flash 1s infinite"; // Aplica una animación de parpadeo
    }, 100); // Restablece el color original después de 100 ms
});

