// let value = [
//     [0, 0],
//     [1, 1],
//     [2, 8],
//     [4, 64]
// ];

let value2 = [
    [0, -5],
    [1, 2],
    [2, 5],
    [3, 10],
    [4, 30]
];

function Newton(arr2d, n) {
    let soTSP = arr2d.length - 1;
    let size = arr2d.length;
    let arrTSP = Array.from({ length: soTSP + 2 }, (a, b) => {
        return [];
    });
    for (let i = 0; i < size; i++) {
        arrTSP[0].push(arr2d[i][0]);
        arrTSP[1].push(arr2d[i][1]);
    }
    for (let i = 1; i <= soTSP; i++) {
        for (let j = 0; j < soTSP + 1 - i; j++) {
            let x0 = arrTSP[0][j],
                x = arrTSP[0][j + i],
                y0 = arrTSP[i][j],
                y = arrTSP[i][j + 1];
            arrTSP[i + 1].push(tinhTSP(x0, x, y0, y));
        }
    }
    let result = arrTSP[1][0];
    let temp = 1;
    for (let i = 0; i < soTSP; i++) {
        temp *= (n - arrTSP[0][i]);
        result += temp * arrTSP[i + 2][0];
    }
    return result;
}

function tinhTSP(x0, x, y0, y) {
    return (y - y0) / (x - x0);
}

// Newton(value, 3);
console.log(Newton(value2, 2.5));
// console.log(tinhTSP(2, 4, 8, 64));