var exec = require("cordova/exec");
var PLUGIN_NAME = "WowzaPlayer";

exports.createPlayer = function (success, error, args) {
	exec(success, error, PLUGIN_NAME, "createPlayer", [args]);
};
