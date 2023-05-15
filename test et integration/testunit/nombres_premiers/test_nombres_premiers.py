from nombres_premiers import *

import unittest


class TestNombresPremier(unittest.TestCase):
    def test_nominal(self):
        """Nominal test case"""
        self.assertTrue(True)

    def test_nominal2(self):
        """Nominal test case 2"""
        var = 1
        self.assertEqual(var, 1)


suite = unittest.TestLoader().loadTestsFromTestCase(TestNombresPremier)
unittest.TextTestRunner(verbosity=2).run(suite)
