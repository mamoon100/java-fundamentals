function or(a,b) {
  if (a === 1)
    return 1
  if (b === 1)
    return 1
  else
    return 0
}

function xor(a,b) {
  if (and(a,b))
    return 0;
  return or(a,b);
}
function not(a) {
  if (a === 0)
    return 1
  else
    return 0
}
function add1(a,b) {
  overflow = and(a,b)
  sum = xor(a,b)
  return {sum, overflow}
}

function zadd1(a,b,z) {
  var ones, zf;
  zf = or(or(and(a,b), and(b,z)), and(a,z));

  j = or(a, nor(b,z));
  k = or(b, nor(a,z))
  l = or(z, nor(a,b))

  console.log("jkl", j, k, l);

  ones = xor(j, xor(k, l));
  return {ones, zf};
}

function add2(a,b) {
  twos = add1(a[0], b[0])
  ones = add1(a[1], b[1]);

}
console.log("xor 00", xor(0,0))
console.log("xor 01", xor(0,1))
console.log("xor 10", xor(1,0))
console.log("xor 11", xor(1,1))
console.log()
