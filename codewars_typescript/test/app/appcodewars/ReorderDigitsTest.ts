import {expect} from 'chai';
import { reorderDigits} from '../../../src/app/codewars/ReorderDigits';

describe('ReorderDigits test', () => {
    it('ReorderDigits test should work', () => {
        expect(reorderDigits(42145)).to.eql(54421);
        expect(reorderDigits(145263)).to.eql(654321);
        expect(reorderDigits(1234567890)).to.eql(9876543210);
    })
})