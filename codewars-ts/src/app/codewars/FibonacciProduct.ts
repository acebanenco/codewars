export function fibonacciProduct(product: number): (number|boolean)[] {
    let fibonacciNumber:number[] = [0,1];
    while(fibonacciNumber[0] * fibonacciNumber[1] < product) {
        const nextNumber: number = fibonacciNumber[0] + fibonacciNumber[1];
        fibonacciNumber[0] = fibonacciNumber[1];
        fibonacciNumber[1] = nextNumber;
    }
    return [
        fibonacciNumber[0],
        fibonacciNumber[1],
        product == fibonacciNumber[0] * fibonacciNumber[1]];
}