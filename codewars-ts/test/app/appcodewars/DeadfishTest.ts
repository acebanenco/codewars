import {expect} from 'chai';
import { deadfish } from "../../../src/app/codewars/Deadfish";

describe('Deadfish test', () => {
    it('Deadfish test should pass', () => {
        expect(deadfish('iiisdoso')).to.eql([8, 64]);
    });
});