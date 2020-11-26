// let value = [
//     [1, 1],
//     [2, 5],
//     [3, 21],
//     [4, 55]
// ];

// let value2 = [
//     [0.25, 0.255307],
//     [0.5, 0.544987],
//     [0.75, 0.917916],
//     [1, 1.462652]
// ];


function toHop(soLon, soBe) {
    return giaiThua(soLon) / (giaiThua(soBe) * giaiThua(soLon - soBe));
}

function giaiThua(n) {
    let result = 1;
    for (let i = 1; i <= n; i++) {
        result *= i;
    }
    return result;
}

function lagrange(arr2d, n) {
    n = (n - Math.abs(arr2d[0][0] - arr2d[1][0])) / Math.abs(arr2d[0][0] - arr2d[1][0]);
    let size = arr2d.length - 1;
    let result = 0;
    for (let i = 0; i <= size; i++) {
        result += (hangSoTrongCongThuc(n, size) * (-1) ** (size - i) * toHop(size, i) * arr2d[i][1]) / ((n - i) * giaiThua(size));
    }
    return result.toFixed(6);
}

function hangSoTrongCongThuc(n, size) {
    let result = 1;
    for (let i = 0; i < size + 1; i++) {
        result *= (n - i);
    }
    return result;
}

// console.log(toHop(15, 3));
// console.log(lagrange(value, 3.5));
// console.log(lagrange(value2, 0.7));