import {expect} from 'chai'
import { fibonacciProduct } from '../../../src/app/codewars/FibonacciProduct';

describe('FibonacciProduct test', () => {
    it('FibonacciProduct test should work', () => {
        expect(fibonacciProduct(714)).to.eql([21, 34, true], ''),
        expect(fibonacciProduct(800)).to.eql([34, 55, false], '')
    })
})