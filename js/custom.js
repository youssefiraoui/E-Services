// chtti hado kamline .. gha init
$('.ui.checkbox')
  .checkbox()
;
$('select.dropdown')
  .dropdown()
;
$('#date-de-naissance').calendar({
  type: 'date'
});

// dik l3ayba dial ila klika 3la hadi kliki 3la hadik : lwahm
$('#submit-con-').click(function(){
	$('#submit-con').click();
});
// dik l3ayba dial ila klika 3la hadi kliki 3la hadik : lwahm
$('#submit-signup-').click(function(){
	$('#submit-signup').click();
});
// ha trigger dial modal dial connexion + signup
$('.modal.connexion')
  .modal('attach events', '.trigger-con')
;
$('.modal.signup')
  .modal('attach events', '.trigger-signup')
;

$('#conditions').change(function() {
  $('#submit-signup-').toggleClass('disabled');
});



// hna bach l corp-metiers-files ybano olla maybanoch
$('input[type=radio][name=user-type]').on('change', function() {
     $('#corp-metiers-files').slideToggle();
});
// hna ndiro like
$('.heart').click(function(){
	$(this).toggleClass('red');
});