export function isInteresting(n: number, awesomePhrases: number[]): number {
    if ( isInterestingImpl(n, awesomePhrases) ) {
        return 2;
    }
    for(let i=1; i<=2; i++) {
        if ( isInterestingImpl(n + i, awesomePhrases) ) {
            return 1;
        }
    }
    return 0;
}

function isInterestingImpl(n: number, awesomePhrases: number[]): boolean {
    if ( awesomePhrases.indexOf(n) >= 0 ) {
        return true;
    }
    const s = n.toString();
    return s.length >= 3 && (
        /^[1-9]0+$/.test(s) || 
        /^([1-9])\1+$/.test(s) ||
        '1234567890'.indexOf(s) >= 0 || 
        '9876543210'.indexOf(s) >= 0 || 
        s === s.split("").reverse().join(""));
}

