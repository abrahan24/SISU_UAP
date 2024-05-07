$(document).ready(function() {
    $(".toggle-password-visibility").click(function() {
        var passwordInput = $(this).siblings(".password-input");
        passwordInput.prop("type", passwordInput.prop("type") === "password" ? "text" : "password");
    });
});



