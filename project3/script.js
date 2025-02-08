function performStatistics() {
    let numString = document.getElementById("numField").value;
    let numArray = numString.split(" ");

    //change from str to float
    for(let i = 0; i < numArray.length; i++) {
        numArray[i] = parseFloat(numArray[i]);
    }

    //sort numerically
    numArray.sort(function(a, b){ return a - b; });

    //change readonly values
    min.value = findMin(numArray).toFixed(2);
    max.value = findMax(numArray).toFixed(2);
    sum.value = calcSum(numArray).toFixed(2);
    mean.value = calcMean(numArray).toFixed(2);
    median.value = calcMedian(numArray).toFixed(2);
    mode.value = calcMode(numArray);
    variance.value = calcVariance(numArray).toFixed(2);
    stdDev.value = calcStdDev(numArray).toFixed(2);

    return false;
}

function calcMean(array) {
    let sum = calcSum(array);
    return sum / array.length;
}

function calcMedian(array) {
    let length = array.length;
    let median = 0;
    //finding for even length
    if(length % 2 == 0) {
        let temp = (length / 2) - 1;
        median = (array[temp] + array[temp + 1]) / 2;
    //finding for odd length
    } else {
        median = array[Math.floor(length / 2)];
    }

    return median;
}

function calcMode(array) {

    let bestStreak = 1;
    let currentStreak = 1;
    let mode;

    for(let i = 0; i < array.length; i++){
        if(array[i] == array[i + 1]){
            currentStreak++;
            if(currentStreak > bestStreak){
                //adding mode
                mode = String(array[i]);
                bestStreak = currentStreak;
            
            } else if (currentStreak == bestStreak){
                //adding extra modes
                mode += " " + String(array[i]);
            }
        } else if(array[i] != array[i + 1]){
            //reseting streak
            currentStreak = 1;
        }
    }
    
    return mode;
}


function calcStdDev(array) {
    let stdDev = Math.sqrt(calcVariance(array));
    return stdDev;
}

function calcSum(array) {
    let sum = 0;
    for(let i = 0; i < array.length; i++) {
        sum += array[i];
    }
    return sum;
}

function calcVariance(array) {
    let mean = calcMean(array);
    let tempArr = array.slice();
    for(let i = 0; i < array.length; i++) {
        //finding difference
        tempArr[i] -= mean;
        //squaring nums
        tempArr[i] *= tempArr[i];
    }
    
    let varMean = calcMean(tempArr);
    return varMean;
}

function findMax(array) {
    let max = array[array.length - 1];
    return max;
}

function findMin(array) {
    let min = array[0];
    return min;
}