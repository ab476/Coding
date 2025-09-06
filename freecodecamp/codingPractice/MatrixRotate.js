/**
 * Rotates a square matrix 90 degrees clockwise.
 * @param {number[][]} matrix 
 * @returns {number[][]}
 */
function rotate(matrix) {
  const m = [];
  const n = matrix.length;
  for(let i = 0; i < n; i++) {
    m[i] = [];
    for(let j = 0; j < n; j++) {
      m[i][j] = matrix[n - 1 - j][i];
    }
  }
  return m;
}