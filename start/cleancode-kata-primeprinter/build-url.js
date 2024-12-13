function buildUrl(url, options = {}) {
    let builtUrl = url || '';

    if (options.path) {
        builtUrl += '/' + options.path;
    }

    if (options.queryParams) {
        const queryString = Object.keys(options.queryParams)
            .map(key => `${key}=${options.queryParams[key]}`)
            .join('&');
        builtUrl += '?' + queryString;
    }

    if (options.hash) {
        builtUrl += '#' + options.hash;
    }

    return builtUrl;
}
