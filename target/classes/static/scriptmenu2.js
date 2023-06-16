$("#menu-toggle").click(function(e) {
   e.preventDefault();
   $("#wrapper").toggleClass("toggled");
});

$("#menu-toggle-2").click(function(e) {
   e.preventDefault();
   $("#wrapper").toggleClass("toggled-2");
   $('#menu ul').hide();
});

function initMenu() {
   $('#menu ul').hide();
   $('#menu ul').children('.current').parent().show();
   $('#menu li a').click(function() {
      var checkElement = $(this).next();
      if (checkElement.is('ul')) {
         if (checkElement.is(':visible')) {
            checkElement.slideUp('normal');
         } else {
            $('#menu ul:visible').slideUp('normal');
            checkElement.slideDown('normal');
         }
         return false;
      }
   });
}

$(document).ready(function() {
   initMenu();
});