const proxy = [
    {
        context: '/api',
        secure: true,
        target: 'http://localhost:8080/fipe-rest',
        pathRewrite: { '^/api': '' }
    }
];
module.exports = proxy;