export function humanReadable(seconds:number): string {
    const minutes = Math.floor(seconds / 60);
    const hours = Math.floor(minutes / 60);
    const timeParts = [hours % 100, 
        minutes % 60, 
        seconds % 60
    ];
    return timeParts.map(n => (""+n).padStart(2, '0')).join(':');
}
