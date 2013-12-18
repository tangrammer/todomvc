/*global $ */
/*jshint unused:false */
var app = app || {};
var ENTER_KEY = 13;

$(function () {
	'use strict';

	// kick things off by creating the `App`
	window.appview = new app.AppView();

  window.benchmark1 = function() {
    var s = new Date();
    for(var i = 0; i < 200; i++) {
      app.todos.create({
        order: app.todos.nextOrder(),
        title: "foo",
        completed: false
      });
    }
    document.getElementById("message").innerHTML = ((new Date())-s) + "ms";
  };

  window.benchmark2 = function() {
    var s = new Date();

    for(var i = 0; i < 200; i++) {
      app.todos.create({
        order: app.todos.nextOrder(),
        title: "foo",
        completed: false
      });
    }

    for(var i = 0; i < 5; i++) {
      appview.allCheckbox.checked = !appview.allCheckbox.checked;
      appview.toggleAllComplete();
    }

    appview.clearCompleted();
    document.getElementById("message").innerHTML = ((new Date())-s) + "ms";
  };
});
