function solution(files) {
    let number = new Set(['0', '1', '2', '3', '4', '5', '6', '7', '8', '9']);
    
    files.sort((x, y) => {
        let a = x.split("");
        let b = y.split("");
        
        let ahead = '';
        let anumber = '';
        let bhead = '';
        let bnumber = '';
        
        let aindex = 0;
        let bindex = 0;
        let index = 0;
        
        // A HEAD
        for (let value of a) {
            if (!number.has(value)) {
                aindex++;
            } else {
                ahead = x.slice(0, aindex).toLowerCase();
                break;
            }
        }
        
        // A NUMBER
        index = aindex;
        while (index < x.length && number.has(a[index]) && anumber.length < 5) {
            anumber += a[index];
            index++;
        }
        
        // B HEAD
        for (let value of b) {
            if (!number.has(value)) {
                bindex++;
            } else {
                bhead = y.slice(0, bindex).toLowerCase();
                break;
            }
        }
        
        // B NUMBER
        index = bindex;
        while (index < y.length && number.has(b[index]) && bnumber.length < 5) {
            bnumber += b[index];
            index++;
        }
        
        if (ahead > bhead) {
            return 1;   
        }
        
        if (bhead > ahead) {
            return -1;
        }
        
        if (Number(anumber) > Number(bnumber)) {
            return 1;
        }
        
        if (Number(bnumber) > Number(anumber)) {
            return -1;
        }
        
        return 0;
    })
    
    return files;
}
