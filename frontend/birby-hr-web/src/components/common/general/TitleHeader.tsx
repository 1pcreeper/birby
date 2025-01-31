import TitleHeaderProps from "./props/TitleHeaderProps";

function TitleHeader({ title }: TitleHeaderProps) {
    return (
        <>
            <div className="mb-10">
                <h1 className="text-5xl font-medium">
                    {title}
                </h1>
            </div>
        </>
    );
}
export default TitleHeader;