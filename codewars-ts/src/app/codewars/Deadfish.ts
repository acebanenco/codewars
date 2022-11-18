export function deadfish(input:string): number[] {
    let result: number[] = [];
    let actions:Map<string,any> = deadfishActions(result);

    let value: number = 0;
    for ( let index = 0; index < input.length; index++ ) {
        let command:string = input.charAt(index);
        value = deadfishExecute(command, actions, value);
    }
    return result;
}

function deadfishExecute(command:string, actions:Map<string,any>, value:number): number {
    let action = actions.get(command);
    if ( action != null ) {
        return action(value);
    }
    return value;
}

function deadfishActions(result:number[]): Map<string,any> {
    return new Map<string,any>([
        ["i", (n: number): number => n + 1],
        ["d", (n: number): number => n - 1],
        ["s", (n: number): number => n * n],
        ["o", (n: number): number => {
            result.push(n); 
            return n;
        }],
        
    ]);
}