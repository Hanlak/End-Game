// Make this a function.
function checkProgress() {
  if ($("input:radio[name*='game']:checked").length != 0) {
    $('.btn').prop('disabled', false);
  } else {
    $('.btn').prop('disabled', true);
  }
}

$(function () {
  // Set the status once the doc loads.
  checkProgress();
  // Set it again when any of the radio buttons are clicked.
  $("input:radio[name*='game']").on("click change", checkProgress);
});