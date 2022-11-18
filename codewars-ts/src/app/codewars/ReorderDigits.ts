export function reorderDigits(n:number):number {
    let digitCounts: number[] = new Array(10).fill(0);
    while(n > 0) {
        digitCounts[n%10]++;
        n = Math.floor(n / 10);
    }
    let result: number = 0;
    let factor: number = 1;
    for( let digit in digitCounts) {
        let count: number = digitCounts[digit];
        for(var i=0; i<count;i++) {
            result += +digit * factor;
            factor *= 10;
        } 
    }
    return result;

    let str: string = n.toString();
    let chars: string[] = str.split("");
    chars.sort();
    chars.reverse();
    let orderedDigits: string = chars.join("");
    let orderedNumber: Number = new Number(orderedDigits);
    return orderedNumber.valueOf();
}
