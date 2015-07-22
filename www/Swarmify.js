function Swarmify(){}

Swarmify.prototype.showLeaderboards=function(callbackOK, callbackErr){
    cordova.exec(callbackOK, callbackErr, 'Swarmify', 'showLeaderboards', []);
}
Swarmify.prototype.showDashboard=function(callbackOK, callbackErr){
    cordova.exec(callbackOK, callbackErr, 'Swarmify', 'showDashboard', []);
}
Swarmify.prototype.showAchievements=function(callbackOK, callbackErr){
    cordova.exec(callbackOK, callbackErr, 'Swarmify', 'showAchievements', []);
}
Swarmify.prototype.submitScore=function(data, callbackOK, callbackErr){
    cordova.exec(callbackOK, callbackErr, 'Swarmify', 'submitScore', [data]);
}
Swarmify.prototype.getData=function(key, callbackOK, callbackErr){
    cordova.exec(callbackOK, callbackErr, 'Swarmify', 'getData', [key]);
}
Swarmify.prototype.login=function(appid, auth, leaderid,callbackOK, callbackErr){
    cordova.exec(callbackOK, callbackErr, 'Swarmify', 'login', [appid, auth, leaderid]);
}
Swarmify.prototype.setData=function(key, data, callbackOK, callbackErr){
    cordova.exec(callbackOK, callbackErr, 'Swarmify', 'setData', [key, data]);
}
module.exports=new Swarmify();
