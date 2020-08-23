module.exports.handler = function(event, context, callback) {
    callback(null, {
        statusCode: 200,
        body: 'Node.js Hello World!'
    });
};
