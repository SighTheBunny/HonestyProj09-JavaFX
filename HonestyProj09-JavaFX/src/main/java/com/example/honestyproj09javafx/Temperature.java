package com.example.honestyproj09javafx;

public class Temperature {
    /* Data fields */
    private double degree;
    private char scale = 'c'; // default scale is celsius

    /* Class Constructors */
    public Temperature() {
        /* Default constructor sets values to 0.0 and an empty char */
        this(0.0, 'c');
    }
    public Temperature(double degree)
    {
        this.degree = degree;
    }
    public Temperature(char scale)
    {
        this.scale = scale;
        this.degree = 0;
    }
    public Temperature(double degree, char scale)
    {
        this.degree = degree;
        this.scale = scale;
    }

    /* Accessor Methods */
    public double getDegreeInCelsius()
    {
        /* Checks if scale is C(elcius) or F(ahrenheight)
         * If C, degree is simply returned.
         * If F, the degree is calcualted using formula C = (degree - 32) * 5/9.
         */

        if (this.scale == 'c' || this.scale == 'C')
            return this.degree;
        else
        {
            double C, round;
            C = (this.degree - 32) * 5 / 9;
            round = Math.round(C * 100.0) / 100.0;
            return round;
        }


    }
    public double getDegreeInFahrenheight()
    {
        /* Checks if scale is C(elcius) or F(ahrenheight)
         * If C, the degree is calculated using F = (1.8 * degree + 32).
         * If F, the degree is simply returned.
         */

        if (this.scale == 'f' || this.scale == 'F')
            return this.degree;
        else
        {
            double F, round;
            F = (1.8 * this.degree) + 32;
            round = Math.round(F * 100.0) / 100.0;
            return round;
        }

    }

    /* Mutator Methods */
    public void setDegree(double degree)
    { this.degree = degree; }
    public void setDegree(char scale)
    { this.scale = scale; }
    public void setDegree(double degree, char scale)
    {
        this.degree = degree;
        this.scale = scale;
    }

    /* Class Methods */
    public boolean equals(Temperature temperature)
    {
        if (this.getDegreeInCelsius() == temperature.getDegreeInCelsius())
            return true;
        else
            return false;

    }
    public boolean isLessThan(Temperature temperature)
    {
        if (this.getDegreeInCelsius() < temperature.getDegreeInCelsius())
            return true;
        else
            return false;
    }
    public boolean isGreaterThan(Temperature temperature)
    {
        if (this.getDegreeInCelsius() > temperature.getDegreeInCelsius())
            return true;
        else
            return false;
    }
}
