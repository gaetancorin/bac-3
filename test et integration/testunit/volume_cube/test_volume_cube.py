from volume_cube import *

import unittest

class TestCube(unittest.TestCase):
    def test_nominal_parameter_entier(self):
        var = volume_cube(3)
        print(var)
        self.assertEqual(var, 27)

    def test_nominal_parameter_float(self):
        var = volume_cube(2.5)
        print(var)
        self.assertEqual(var, 15.625)

    def test_erreur_parameter_at_zero(self):
         with self.assertRaises(ValueError):
            var = volume_cube(0)

    def test_erreur_parameter_negatif_entier(self):
         with self.assertRaises(ValueError):
            var = volume_cube(-2)

    def test_erreur_parameter_negatif_float(self):
         with self.assertRaises(ValueError):
            var = volume_cube(-2.5)

    def test_erreur_parameter_vide(self):
        with self.assertRaises(ValueError):
            var = volume_cube("")

    def test_erreur_parameter_string(self):
        with self.assertRaises(TypeError):
            var = volume_cube("string")

suite = unittest.TestLoader().loadTestsFromTestCase(TestCube)
unittest.TextTestRunner(verbosity=2).run(suite)

# self.assertRaises(ValueError)
# self.assertEqual(var, 1)
# self.assertTrue(True)