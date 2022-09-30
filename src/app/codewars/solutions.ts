export function arrayDiff(a:number[], b:number[]): number[] {
    const bSet = new Set(b);
    return a.filter(el => !bSet.has(el));

    let result : number[] = [];
    let bset: Set<number> = new Set(b);
    for( var i in a) {
        let e: number = a[i];
        if ( bset.has(e) ) {
            continue;
        }
        result.push(e);
    }
    return result;
}